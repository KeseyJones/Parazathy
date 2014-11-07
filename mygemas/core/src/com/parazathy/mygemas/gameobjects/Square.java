package com.parazathy.mygemas.gameobjects;


public class Square  {
	public enum Type {sqEmpty,
					  sqWhite,
					  sqRed,
					  sqPurple,
					  sqOrange,
					  sqGreen,
					  sqYellow,
					  sqBlue};
	
	public int origY;
	public int destY;
	public boolean mustFall;
	private Type type;
	
	public Square(Type type) {
		this.type = type;
		this.mustFall = false;
	}
	
	public Square(Square other) {
		this.type = other.type;
		this.origY = other.origY;
		this.destY = other.destY;
		this.mustFall = other.mustFall;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean equals(Square other) {
		return other.type == this.type;
	}
	
	public boolean equals(Type type) {
		return this.type == type;
	}
	
	public static Type numToType(int num) {
		switch (num) {
		case 1:
			return Type.sqWhite;
		case 2:
			return Type.sqRed;
		case 3:
			return Type.sqPurple;
		case 4:
			return Type.sqOrange;
		case 5:
			return Type.sqGreen;
		case 6:
			return Type.sqYellow;
		case 7:
			return Type.sqBlue;
		default:
			return Type.sqEmpty;
		}
	}
}