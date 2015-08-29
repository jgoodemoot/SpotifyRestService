package com.spotify.exercise.domain;

import java.util.List;

public class Albums {
	private String href;
	private List<Album> items;
	private String limit;
	private String next;
	private String offset;
	private String previous;
	private String total;

	/**
	 * 
	 * @return
	 */
	public String getHref(){
		return this.href;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setHref(String value){
		this.href = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Album> getItems(){
		return this.items;
	}
	
	/**
	 * 
	 * @param albums
	 */
	public void setItems(List<Album> albums){
		this.items = albums;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLimit(){
		return this.limit;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setLimit(String value){
		this.limit = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNext(){
		return this.next;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setNext(String value){
		this.next = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOffset(){
		return this.offset;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setOffset(String value){
		this.offset = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPrevious(){
		return this.previous;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setPrevious(String value){
		this.previous = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTotal(){
		return this.total;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setTotal(String value){
		this.total = value;
	}
}
