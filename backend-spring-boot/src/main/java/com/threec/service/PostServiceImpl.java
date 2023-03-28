package com.threec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Consumer;
import com.threec.beans.Post;
import com.threec.dao.PostDao;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	PostDao postDao;
	
	@Autowired
	ConsumerService consumerService;

	// CREATE A NEW POST
	@Override
	public Post create(Post post, String username) {
		Consumer found=consumerService.findByUsername(username);
		if(found==null) return null;
		
		post.setConsumer(found);
		return postDao.save(post);
	}

	// RETRIEVE ALL THE POSTS CREATED BY A CONSUMER
	@Override
	public List<Post> readAllForConsumer(String username) {
		Consumer found=consumerService.findByUsername(username);
		if(found==null) return null;
		
		return found.getPosts();
	}
	
	
}
