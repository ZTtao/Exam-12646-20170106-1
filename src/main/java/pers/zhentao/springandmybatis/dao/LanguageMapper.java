package pers.zhentao.springandmybatis.dao;

import java.util.List;

import pers.zhentao.springandmybatis.pojo.Language;

public interface LanguageMapper {
	List<Language> selectAll();
	Language selectByPrimaryKey(Integer languageId);
}