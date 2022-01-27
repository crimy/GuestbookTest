package GuestBook;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CtrlGuestBook {

    private JdbcTemplate jdbcTemplate = null;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // list.gb : ���� �Խ�
    @RequestMapping("/list.gb")
    public ModelAndView list() throws Exception {
        ModelAndView mnv = new ModelAndView();
        RowMapper<GuestBookVO> rowMapper = new RowMapper<GuestBookVO>() {
            @Override
            public GuestBookVO mapRow(ResultSet rs, int arg1) throws SQLException {
                GuestBookVO vo = new GuestBookVO();
                vo.setNo(rs.getInt("no"));
                vo.setContent(rs.getString("content"));
                vo.setPassword(rs.getString("password"));

                return vo;
            }

        };
        List<GuestBookVO> list = jdbcTemplate.query("SELECT * FROM Guestbook", rowMapper);

        mnv.setViewName("guestbook_list");
        mnv.addObject("list", list);
        return mnv;
    }

    // add.gb : ���� �ۼ� , ������ ��й�ȣ�� ���� �Է�,��ȣ �ڵ�
    @RequestMapping("/add.gb")
    public String add(@RequestParam("content") String content, @RequestParam("password") String password)
            throws Exception {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                String sql = "INSERT INTO Guestbook VALUES(default,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, content);
                stmt.setString(2, password);
                return stmt;
            }

        };
        jdbcTemplate.update(psc);
        return "redirect:list.gb";
    }

    // del.gb : ������ ���� ��й�ȣ �Է������� del_form �̵�
    @RequestMapping("/del.gb")
    public ModelAndView del(@RequestParam("no") int no) throws Exception {
        ModelAndView mnv = new ModelAndView();

        mnv.setViewName("del_form");
        mnv.addObject("no", no);
        return mnv;
    }

    // del_form ���� ��й�ȣ ��ġ �� �ش� ���ڵ� ����
    @RequestMapping("/del2.gb")
    public String del(HttpServletRequest request, HttpServletResponse response, @RequestParam("no") int no,
            @RequestParam("password") String password) throws Exception {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM Guestbook WHERE no = ? && password = ?");
                stmt.setInt(1, no);
                stmt.setString(2, password);
                return stmt;
            }

        };
        int i = jdbcTemplate.update(psc);

        if (i != 1) {
            Util.alert(response, "�߸��� ��й�ȣ�Դϴ�");
        }
        return "redirect:list.gb";
    }
}

/*
 * CREATE TABLE Guestbook( no INT NOT NULL AUTO_INCREMENT PRIMARY KEY, content
 * VARCHAR(500) NULL, password CHAR(4) NULL );
 * 
 * 
 * 
 */