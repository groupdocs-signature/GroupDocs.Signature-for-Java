package com.groupdocs.ui.signature.entity.web;

import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.signature.entity.xml.XmlEntity;

public class SignaturePageEntity extends PageDescriptionEntity {
    private XmlEntity props;

    public XmlEntity getProps() {
        return props;
    }

    public void setProps(XmlEntity props) {
        this.props = props;
    }
}
