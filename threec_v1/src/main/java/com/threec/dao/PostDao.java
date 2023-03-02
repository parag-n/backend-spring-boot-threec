package com.threec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threec.beans.Post;

public interface PostDao extends JpaRepository<Post, Integer>{

}
