package io.github.jast90.common.form;

public class CommonMultiDomainForm<D1,D2> {
    private D1 domain1;
    private D2 domain2;

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
}
