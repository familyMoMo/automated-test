package self.family.entry;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2015/8/22.
 */
public class TestResult implements Serializable{
    private static final long serialVersionUID = -8276312674885022325L;
    private int id;
    private int caseId;
    private String caseName;
    private String expectResponse;
    private String actualResponse;
    private String result;
    private int tag;
    private String tagName;
    private Date createTime;

    public TestResult() {
    }

    public TestResult(int caseId, String caseName, String expectResponse, String actualResponse, String result, int tag, String tagName, Date createTime) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.expectResponse = expectResponse;
        this.actualResponse = actualResponse;
        this.result = result;
        this.tag = tag;
        this.tagName = tagName;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getExpectResponse() {
        return expectResponse;
    }

    public void setExpectResponse(String expectResponse) {
        this.expectResponse = expectResponse;
    }

    public String getActualResponse() {
        return actualResponse;
    }

    public void setActualResponse(String actualResponse) {
        this.actualResponse = actualResponse;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
