
package it.hoanguyenminh.stackoverflowuser.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BadgeCounts {

    @SerializedName("bronze")
    private Long mBronze;
    @SerializedName("gold")
    private Long mGold;
    @SerializedName("silver")
    private Long mSilver;

    public Long getBronze() {
        return mBronze;
    }

    public void setBronze(Long bronze) {
        mBronze = bronze;
    }

    public Long getGold() {
        return mGold;
    }

    public void setGold(Long gold) {
        mGold = gold;
    }

    public Long getSilver() {
        return mSilver;
    }

    public void setSilver(Long silver) {
        mSilver = silver;
    }

}
