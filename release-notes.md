# Release Notes


## 0.3.0 (2014-09-21)
- Check argument of object based Wrappers (String, BigInteger, BigDecimal), does not allow null value.
- Change Value#getValue to return the technical type which is a sub type of Comparable instead of object,
  breaks backward compatibility.
- moved Value#asChar and Value#asCharacter to CharWrapper, breaks backward compatibility.

## 0.2.0 (2014-09-07)
- In AbstractValue a #toString Method is added. It prints the implementing class and the value.
- The metaType parameter was removed. It was not necessary and simplifies the API. On the other
  hand this change breaks backward compatibility.

## 0.1.0 (2014-08-17)
- Initial release.
