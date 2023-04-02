package com.threec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.threec.beans.Expertise;
import com.threec.beans.Post;

public interface PostDao extends JpaRepository<Post, Integer>{

	@Query("select post from Post post where post.address.city=:city and post.category in :elist and post.status=0")
	List<Post> findAllForServiceProvider( @Param("city") String city, @Param("elist") List<Expertise> elist);}
