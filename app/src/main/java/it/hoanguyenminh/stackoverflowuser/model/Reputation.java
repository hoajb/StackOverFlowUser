
package it.hoanguyenminh.stackoverflowuser.model;

import com.google.gson.annotations.SerializedName;

public class Reputation extends BaseModel{

    @SerializedName("creation_date")
    private Long mCreationDate;
    @SerializedName("post_id")
    private Long mPostId;
    @SerializedName("reputation_change")
    private Long mReputationChange;
    @SerializedName("reputation_history_type")
    private String mReputationHistoryType;
    @SerializedName("user_id")
    private Long mUserId;

    public Long getCreationDate() {
        return mCreationDate;
    }

    public void setCreationDate(Long creationDate) {
        mCreationDate = creationDate;
    }

    public Long getPostId() {
        return mPostId;
    }

    public void setPostId(Long postId) {
        mPostId = postId;
    }

    public Long getReputationChange() {
        return mReputationChange;
    }

    public void setReputationChange(Long reputationChange) {
        mReputationChange = reputationChange;
    }

    public String getReputationHistoryType() {
        return mReputationHistoryType;
    }

    public void setReputationHistoryType(String reputationHistoryType) {
        mReputationHistoryType = reputationHistoryType;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

}
