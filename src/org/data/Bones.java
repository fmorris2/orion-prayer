package org.data;

public enum Bones
{
	NORMAL(526, "Bones"),
	BIG_BONES(532, "Big bones");
	
	public final int ID;
	public final String SEARCH_TERM;
	Bones(int id, String search)
	{
		ID = id;
		SEARCH_TERM = search;
	}
}
