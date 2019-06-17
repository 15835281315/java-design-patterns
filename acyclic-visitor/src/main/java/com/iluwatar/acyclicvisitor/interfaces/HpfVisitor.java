package com.iluwatar.acyclicvisitor.interfaces;

import com.iluwatar.acyclicvisitor.Hpf;

//测试访问
public interface HpfVisitor extends ModemVisitor {

    void visit(Hpf hpf);

}
