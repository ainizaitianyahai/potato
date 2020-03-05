package com.potato.entity;

public class MyStruct_ES {

 	public String _index;
    public String _type;
    public String _id;
    public Integer _version;
    public Boolean found;
    public MySource_ES _source;
	public String get_index() {
		return _index;
	}
	public void set_index(String _index) {
		this._index = _index;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Integer get_version() {
		return _version;
	}
	public void set_version(Integer _version) {
		this._version = _version;
	}
	public Boolean getFound() {
		return found;
	}
	public void setFound(Boolean found) {
		this.found = found;
	}
	public MySource_ES get_source() {
		return _source;
	}
	public void set_source(MySource_ES _source) {
		this._source = _source;
	}

}
