package xlw.android.researchgroup;

public class Favorite {
	  private long id;
	  private CharSequence name;
	  private CharSequence position;
	  private CharSequence department;
	  private CharSequence university;
	  private CharSequence interest;
	  private int ResearchArea;
	  private int PageNumber;
	  private int element;
	  private String comment;

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public CharSequence getname() {
		    return name;
	  }

	  public void setname(CharSequence name) {
		    this.name = name;
	  }
	  
	  public CharSequence getposition() {
		    return position;
	  }

	  public void setposition(CharSequence position) {
		    this.position = position;
	  }
	  
	  public CharSequence getdepartment() {
		    return department;
	  }

	  public void setdepartment(CharSequence department) {
		    this.department = department;
	  }
	  
	  public CharSequence getuniversity() {
		    return university;
	  }

	  public void setuniversity(CharSequence university) {
		    this.university = university;
	  }
	  
	  public CharSequence getinterest() {
		    return interest;
	  }

	  public void setinterest(CharSequence interest) {
		    this.interest = interest;
	  }
		  
	  public int getResearchArea() {
			 return ResearchArea;
	  }

	  public void setResearchArea(int ResearchArea) {
			  this.ResearchArea = ResearchArea;
	  }
			  
	  public int getPageNumber() {
			  return PageNumber;
	  }

	  public void setPageNumber(int PageNumber) {
			   this.PageNumber = PageNumber;
	  }
				  
	  public int getelement() {
				return element;
	  }

	  public void setelement(int element) {
			   this.element = element;
	  }
		  

	  
	  public String getComment() {
	    return comment;
	  }

	  public void setComment(String comment) {
	    this.comment = comment;
	  }

	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return comment;
	  }
	} 
