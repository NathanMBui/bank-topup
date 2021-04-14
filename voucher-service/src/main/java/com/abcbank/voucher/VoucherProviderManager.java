package com.abcbank.voucher;

/**
 * TODO should use service discovery if have time
 */
public class VoucherProviderManager {

    public VoucherProvider getProvider(String providerName) {
        return new MockVoucherProvider(providerName);
    }

    static class MockVoucherProvider implements VoucherProvider {

        private final String name;

        public MockVoucherProvider(String name) {
            this.name = name;
        }

        public VoucherData getVoucher(String phoneNumber, String type) {
            VoucherData data = new VoucherData();
            long randomNumber = System.currentTimeMillis();
            data.setCode(String.valueOf(randomNumber));
            data.setDescription("2000MB for 30 days");
            data.setProvider(name);
            data.setType(type);
            return data;
        }
    }
}
