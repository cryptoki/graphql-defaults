package de.cryptoki.graphqldefaults.api;

import javax.annotation.Nullable;
import java.util.Objects;

public class SomeOldPojo {

  @Nullable
  public String value;

  @Nullable
  public String notMandatory;

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
