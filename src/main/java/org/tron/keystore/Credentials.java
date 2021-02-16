package org.ypbay.keystore;


import org.ypbay.common.crypto.SignInterface;

public interface Credentials {
  SignInterface getPair();

  String getAddress();
}
