package books;

import java.util.ArrayList;


public class Category {
	
	private int id;
	
	private String name;
	
	private ArrayList list;

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public Category(int id, String name) {
		
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	

}
