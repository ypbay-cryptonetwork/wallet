package org.ypbay.core.zen.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.ypbay.common.zksnark.JLibrustzcash;
import org.ypbay.core.exception.ZksnarkException;

@AllArgsConstructor
public class DiversifierT {
  public static final int ZC_DIVERSIFIER_SIZE = 11;

  @Setter
  @Getter
  private byte[] data = new byte[ZC_DIVERSIFIER_SIZE];

  public DiversifierT() {
  }

  public DiversifierT random() throws ZksnarkException {
    byte[] d;
    while (true) {
      d = org.ypbay.keystore.Wallet.generateRandomBytes(ZC_DIVERSIFIER_SIZE);
      if (JLibrustzcash.librustzcashCheckDiversifier(d)) {
        break;
      }
    }
    return new DiversifierT(d);
  }
}
