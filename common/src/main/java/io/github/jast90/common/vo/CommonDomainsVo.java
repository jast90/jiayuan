package io.github.jast90.common.vo;

/**
 * 含有2个domain
 * @param <D1>
 * @param <D2>
 */
public class CommonDomainsVo<D1,D2,D3,D4> {
    private D1 domain1;
    private D2 domain2;
    private D3 domain3;
    private D4 domain4;

    public D1 getDomain1() {
        return domain1;
    }

    public void setDomain1(D1 domain1) {
        this.domain1 = domain1;
    }

    public D2 getDomain2() {
        return domain2;
    }

    public void setDomain2(D2 domain2) {
        this.domain2 = domain2;
    }

    public D3 getDomain3() {
        return domain3;
    }

    public void setDomain3(D3 domain3) {
        this.domain3 = domain3;
    }

    public D4 getDomain4() {
        return domain4;
    }

    public void setDomain4(D4 domain4) {
        this.domain4 = domain4;
    }
}
