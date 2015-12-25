package com.nfb.realm;

/**
 * 类名：com.nfb.realm.CustomerRealm
 * 创建者： 邓风森 .
 * 创建时间：2015/12/24
 */
public class CustomerRealm extends BaseRealm {
    @Override
    public String getName() {
        return CustomerRealm.class.getSimpleName();
    }
}
