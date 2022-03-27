package com.project.iBook.service;

import com.project.iBook.vo.Result;

public interface FilterService {

    Result findTopBooks(int limit);

    Result findRecentBooks(int limit, String keyword);
}
