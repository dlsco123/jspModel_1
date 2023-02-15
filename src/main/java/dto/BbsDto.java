package dto;

import java.io.Serializable;

public class BbsDto implements Serializable {		
	private static final long serialVersionUID = 1L;
	
	// 게시판 변수들
	private int seq;			// sequence : 글번호 like 사원번호(MySql)
	private String id;			// 작성자
	
	// 댓글 변수들
	private int ref;			// 그룹번호(글번호)
	private int step;			// 행번호
	private int depth;			// 깊이
	
	// 작성글 관련 변수들
	private String title;		// 글 제목
	private String contents;	// 글 내용
	private String wdate;		// 작성일
	
	
	// 기타
	private int del;			// 삭제(추후설명)
	private int readcount;		// 조회수
	
	
	
	
	//TODO constructor
	// 기본 생성자
	public BbsDto() {
	}
	
	// id, title, contents만 필요한 생성자 by 사용자!		why? ex)글번호는 관리자가 입력!
	public BbsDto(String id, String title, String contents) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
	}

	// 모든 함수가 포함된 생성자
	public BbsDto(int seq, String id, int ref, int step, int depth, String title, String contents, String wdate, int del,
			int readcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.contents = contents;
		this.wdate = wdate;
		this.del = del;
		this.readcount = readcount;
	}
	
	// TODO getter & setter
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	
	@Override
	public String toString() {
		return "BbsDto [seq=" + seq + ", id=" + id + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", title="
				+ title + ", contents=" + contents + ", wdate=" + wdate + ", del=" + del + ", readcount=" + readcount
				+ "]";
	}	
}
