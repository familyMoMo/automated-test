package self.family.entry;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



/**
 * Created by Administrator on 2015/8/22.
 */
public class TestCase implements Serializable {

    private static final long serialVersionUID = 1191563118014399824L;
    private int id;
    private String version;
    private String caseName;
    private String url;
    private String requestMethod;
    private String requestHeader;
    private String requestCookie;
    private String requestBody;
    private String requestEncoding;
    private String contentType;
    private String responseResolver;
    private String expectResponse;
    private String description;
    private Date createTime;
    private Date updateTime;

    public TestCase() {
    }

    public TestCase(String version, String caseName, String url, String requestMethod, String requestHeader, String requestCookie, String requestBody, String requestEncoding, String contentType, String responseResolver, String expectResponse, String description, Date createTime, Date updateTime) {
        this.version = version;
        this.caseName = caseName;
        this.url = url;
        this.requestMethod = requestMethod;
        this.requestHeader = requestHeader;
        this.requestCookie = requestCookie;
        this.requestBody = requestBody;
        this.requestEncoding = requestEncoding;
        this.contentType = contentType;
        this.responseResolver = responseResolver;
        this.expectResponse = expectResponse;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TestCase(int id, String caseName, String url, String requestMethod, String requestHeader, String requestCookie, String requestBody, String requestEncoding, String contentType, String responseResolver, String expectResponse, String description, Date updateTime) {
        this.id = id;
        this.caseName = caseName;
        this.url = url;
        this.requestMethod = requestMethod;
        this.requestHeader = requestHeader;
        this.requestCookie = requestCookie;
        this.requestBody = requestBody;
        this.requestEncoding = requestEncoding;
        this.contentType = contentType;
        this.responseResolver = responseResolver;
        this.expectResponse = expectResponse;
        this.description = description;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getRequestCookie() {
        return requestCookie;
    }

    public void setRequestCookie(String requestCookie) {
        this.requestCookie = requestCookie;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestEncoding() {
        return requestEncoding;
    }

    public void setRequestEncoding(String requestEncoding) {
        this.requestEncoding = requestEncoding;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getResponseResolver() {
        return responseResolver;
    }

    public void setResponseResolver(String responseResolver) {
        this.responseResolver = responseResolver;
    }

    public String getExpectResponse() {
        return expectResponse;
    }

    public void setExpectResponse(String expectResponse) {
        this.expectResponse = expectResponse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
