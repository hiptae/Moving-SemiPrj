package kr.co.mpago.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.mpago.domain.Notice;
import kr.co.mpago.mapper.CustomerMapper;
import kr.co.mpago.mapper.MemberMapper;
import kr.co.mpago.util.DBUtils;
import lombok.NoArgsConstructor;


public class CustomerService {

    private static final CustomerService customerService = new CustomerService();
    private CustomerMapper customerMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(CustomerMapper.class);
    private CustomerService() {}

    public static CustomerService getInstance() {
        return customerService;
    }
    //공지사항 등록
    public void addNotice(String nickname, String title, String content, String isAdmin) {
            Notice notice = new Notice();
            notice.setNickname(nickname);
            notice.setTitle(title);
            notice.setContent(content);
            notice.setAdmin(Boolean.parseBoolean(isAdmin));
            customerMapper.insert(notice);
        }
    //공지사항 조회
	public List<Notice> getNotices() {
		 return customerMapper.getList();
	}
	//공지사항 수정
	public void modifyNotice(Long bno, String nickname, String title, String content) {
	        Notice notice = new Notice();
	        notice.setBno(bno);
	        notice.setNickname(nickname);
	        notice.setTitle(title);
	        notice.setContent(content);
	        customerMapper.modify(notice);
	    }

	public void delete(Long bno) {
		customerMapper.delete(bno);
	}
}