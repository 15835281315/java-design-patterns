package com.iluwatar.acyclicvisitor;

import com.iluwatar.acyclicvisitor.interfaces.HpfVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: java-design-patterns
 * @description:
 * @author: hanpengfeng
 * @create: 2019/6/17 11:41
 */
public class ConfigureForHpfVisitor implements HpfVisitor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigureForHpfVisitor.class);

    @Override
    public void visit(Hpf hpf) {
        LOGGER.info(hpf + " 与Hpf配置器一起使用。”.");

    }
}
