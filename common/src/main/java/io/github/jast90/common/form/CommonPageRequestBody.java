package io.github.jast90.common.form;

/**
 * 分页JSON接收请求
 * @param <P>
 * @param <E>
 */
public class CommonPageRequestBody<P,E> {
    private String search;
    private long pageNumber=1;
    private long pageSize=10;
    private P pageRequest;
    private E domain;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public P getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(P pageRequest) {
        this.pageRequest = pageRequest;
    }

    public E getDomain() {
        return domain;
    }

    public void setDomain(E domain) {
        this.domain = domain;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }
}
