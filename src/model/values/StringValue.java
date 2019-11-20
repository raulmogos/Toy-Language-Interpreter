package model.values;

import model.types.StringType;
import model.types.Type;
import utils.exceptions.TypeError;

public class StringValue implements Value {

    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof StringValue)) {
            throw new TypeError("not same type");
        }
        StringValue objStringValue = (StringValue)obj;
        return value.equals(objStringValue.getValue());
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }

    public String toStringValueOnly() {
        return value;
    }

    @Override
    public Type getType() {
        return new StringType();
    }
}
