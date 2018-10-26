
package it.hoanguyenminh.stackoverflowuser.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class User extends BaseModel{

    @SerializedName("accept_rate")
    private Long mAcceptRate;
    @SerializedName("account_id")
    private Long mAccountId;
    @SerializedName("badge_counts")
    private BadgeCounts mBadgeCounts;
    @SerializedName("creation_date")
    private Long mCreationDate;
    @SerializedName("display_name")
    private String mDisplayName;
    @SerializedName("is_employee")
    private Boolean mIsEmployee;
    @SerializedName("last_access_date")
    private Long mLastAccessDate;
    @SerializedName("last_modified_date")
    private Long mLastModifiedDate;
    @SerializedName("link")
    private String mLink;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("profile_image")
    private String mProfileImage;
    @SerializedName("reputation")
    private Long mReputation;
    @SerializedName("reputation_change_day")
    private Long mReputationChangeDay;
    @SerializedName("reputation_change_month")
    private Long mReputationChangeMonth;
    @SerializedName("reputation_change_quarter")
    private Long mReputationChangeQuarter;
    @SerializedName("reputation_change_week")
    private Long mReputationChangeWeek;
    @SerializedName("reputation_change_year")
    private Long mReputationChangeYear;
    @SerializedName("user_id")
    private Long mUserId;
    @SerializedName("user_type")
    private String mUserType;
    @SerializedName("website_url")
    private String mWebsiteUrl;

    public Long getAcceptRate() {
        return mAcceptRate;
    }

    public void setAcceptRate(Long acceptRate) {
        mAcceptRate = acceptRate;
    }

    public Long getAccountId() {
        return mAccountId;
    }

    public void setAccountId(Long accountId) {
        mAccountId = accountId;
    }

    public BadgeCounts getBadgeCounts() {
        return mBadgeCounts;
    }

    public void setBadgeCounts(BadgeCounts badgeCounts) {
        mBadgeCounts = badgeCounts;
    }

    public Long getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(Long creationDate) {
        mCreationDate = creationDate;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public Boolean getIsEmployee() {
        return mIsEmployee;
    }

    public void setIsEmployee(Boolean isEmployee) {
        mIsEmployee = isEmployee;
    }

    public Long getLastAccessDate() {
        return mLastAccessDate;
    }

    public void setLastAccessDate(Long lastAccessDate) {
        mLastAccessDate = lastAccessDate;
    }

    public Long getLastModifiedDate() {
        return mLastModifiedDate;
    }

    public void setLastModifiedDate(Long lastModifiedDate) {
        mLastModifiedDate = lastModifiedDate;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(String profileImage) {
        mProfileImage = profileImage;
    }

    public Long getReputation() {
        return mReputation;
    }

    public void setReputation(Long reputation) {
        mReputation = reputation;
    }

    public Long getReputationChangeDay() {
        return mReputationChangeDay;
    }

    public void setReputationChangeDay(Long reputationChangeDay) {
        mReputationChangeDay = reputationChangeDay;
    }

    public Long getReputationChangeMonth() {
        return mReputationChangeMonth;
    }

    public void setReputationChangeMonth(Long reputationChangeMonth) {
        mReputationChangeMonth = reputationChangeMonth;
    }

    public Long getReputationChangeQuarter() {
        return mReputationChangeQuarter;
    }

    public void setReputationChangeQuarter(Long reputationChangeQuarter) {
        mReputationChangeQuarter = reputationChangeQuarter;
    }

    public Long getReputationChangeWeek() {
        return mReputationChangeWeek;
    }

    public void setReputationChangeWeek(Long reputationChangeWeek) {
        mReputationChangeWeek = reputationChangeWeek;
    }

    public Long getReputationChangeYear() {
        return mReputationChangeYear;
    }

    public void setReputationChangeYear(Long reputationChangeYear) {
        mReputationChangeYear = reputationChangeYear;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public String getUserType() {
        return mUserType;
    }

    public void setUserType(String userType) {
        mUserType = userType;
    }

    public String getWebsiteUrl() {
        return mWebsiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        mWebsiteUrl = websiteUrl;
    }

}
