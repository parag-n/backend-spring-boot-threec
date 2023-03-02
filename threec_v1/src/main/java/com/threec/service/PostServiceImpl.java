package com.threec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Override
	public Post createPost(Post post) {
		int consumerId=post.getConsumer().getConsumerId();;
		Consumer consumer=consumerService.readConsumer(consumerId);
		if(consumer!=null) {
			List<Post> plist=consumer.getPosts();
			if(plist==null) plist=new ArrayList<>();
			plist.add(post);
//			post.setConsumer(consumer);
			consumer.setPosts(plist);
			consumerService.createConsumer(consumer);
			Post created=postDao.save(post);
			return created;
		}
		return null;
	}
}
