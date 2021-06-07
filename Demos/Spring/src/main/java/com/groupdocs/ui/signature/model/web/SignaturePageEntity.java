package com.groupdocs.ui.signature.model.web;

import com.groupdocs.ui.model.response.PageDescriptionEntity;
import com.groupdocs.ui.signature.model.xml.XmlEntity;

public class SignaturePageEntity extends PageDescriptionEntity {
    private XmlEntity props;

    public XmlEntity getProps() {
        return props;
    }

    public void setProps(XmlEntity props) {
        this.props = props;
    }
}
