package org.cigniti;


	
	import javax.annotation.Generated;
	import com.google.gson.annotations.Expose;
	import com.google.gson.annotations.SerializedName;

	@Generated("jsonschema2pojo")
	public class RequestPayload {

	    @SerializedName("image_id")
	    @Expose
	    private String imageId;
	    @SerializedName("sub_id")
	    @Expose
	    private String subId;
	    @SerializedName("value")
	    @Expose
	    private Integer value;

	    /**
	     * No args constructor for use in serialization
	     * 
	     */
	    public RequestPayload() {
	    }

	    /**
	     * 
	     * @param subId
	     * @param imageId
	     * @param value
	     */
	    public RequestPayload(String imageId, String subId, Integer value) {
	        super();
	        this.imageId = imageId;
	        this.subId = subId;
	        this.value = value;
	    }

	    public String getImageId() {
	        return imageId;
	    }

	    public void setImageId(String imageId) {
	        this.imageId = imageId;
	    }

	    public String getSubId() {
	        return subId;
	    }

	    public void setSubId(String subId) {
	        this.subId = subId;
	    }

	    public Integer getValue() {
	        return value;
	    }

	    public void setValue(Integer value) {
	        this.value = value;
	    }

	}



