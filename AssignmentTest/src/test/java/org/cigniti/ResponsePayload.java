package org.cigniti;

import com.google.gson.annotations.Expose;
	import com.google.gson.annotations.SerializedName;

	public class ResponsePayload {
	    @SerializedName("id")
	    @Expose
	    private Integer id;
	    @SerializedName("image_id")
	    @Expose
	    private String imageId;
	    @SerializedName("sub_id")
	    @Expose
	    private String subId;
	    @SerializedName("created_at")
	    @Expose
	    private String createdAt;
	    @SerializedName("value")
	    @Expose
	    private Integer value;
	    @SerializedName("country_code")
	    @Expose
	    private String countryCode;

	    /**
	     * No args constructor for use in serialization
	     * 
	     */
	    public ResponsePayload() {
	    }

	    /**
	     * 
	     * @param subId
	     * @param createdAt
	     * @param imageId
	     * @param countryCode
	     * @param id
	     * @param value
	     */
	    public ResponsePayload(Integer id, String imageId, String subId, String createdAt, Integer value, String countryCode) {
	        super();
	        this.id = id;
	        this.imageId = imageId;
	        this.subId = subId;
	        this.createdAt = createdAt;
	        this.value = value;
	        this.countryCode = countryCode;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getImageId() {
	        return imageId;
	    }

	    public void setImageId(String imageId) {
	        this.imageId = imageId;
	    }

	    public Object getSubId() {
	        return subId;
	    }

	    public void setSubId(String subId) {
	        this.subId = subId;
	    }

	    public String getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(String createdAt) {
	        this.createdAt = createdAt;
	    }

	    public Integer getValue() {
	        return value;
	    }

	    public void setValue(Integer value) {
	        this.value = value;
	    }

	    public Object getCountryCode() {
	        return countryCode;
	    }

	    public void setCountryCode(String countryCode) {
	        this.countryCode = countryCode;
	    }

	}

