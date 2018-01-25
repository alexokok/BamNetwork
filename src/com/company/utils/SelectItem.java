package com.company.utils;

import java.util.List;

public interface SelectItem<T> {
    T func(List<T> items, T item);
}
