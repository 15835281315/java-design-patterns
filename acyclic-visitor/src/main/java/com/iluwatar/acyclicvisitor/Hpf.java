package com.iluwatar.acyclicvisitor;

import com.iluwatar.acyclicvisitor.interfaces.HpfVisitor;
import com.iluwatar.acyclicvisitor.interfaces.ModemVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: java-design-patterns
 * @description:
 * @author: hanpengfeng
 * @create: 2019/6/17 11:37
 */
public class Hpf extends Modem{
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForDosVisitor.class);
    //只接受 HpfVisitor 的实例
    @Override
    public void accept(ModemVisitor modemVisitor) {
        if (modemVisitor instanceof HpfVisitor){
            ((HpfVisitor) modemVisitor).visit(this);
        }else {
            LOGGER.info("只有HpfVisitor被允许访问Hpf调制解调器");
        }
    }

    @Override
    public String toString() {
        return "Hpf modem";
    }
}
