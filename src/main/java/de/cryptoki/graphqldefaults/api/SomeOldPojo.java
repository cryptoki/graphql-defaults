package de.cryptoki.graphqldefaults.api;

import java.util.Objects;

public class SomeOldPojo {

  public String value;

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if (o == null || getClass() != o.getClass()) {return false;}

    SomeOldPojo that = (SomeOldPojo) o;

    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
