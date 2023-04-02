package com.threec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threec.beans.Consumer;
import com.threec.beans.Expertise;
import com.threec.beans.Post;
import com.threec.beans.ServiceProvider;
import com.threec.dao.PostDao;
import com.threec.enums.PostStatus;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	PostDao postDao;
	
	@Autowired
	ConsumerService consumerService;
	
	@Autowired
	ServiceProviderService serviceProviderService;

	// CREATE A NEW POST
	@Override
	public Post create(Post post, String username) {
		Consumer found=consumerService.findByUsername(username);
		if(found==null) return null;
		
		post.setConsumer(found);
		post.setStatus(PostStatus.BIDS_OPEN);
		return postDao.save(post);
	}

	// RETRIEVE ALL THE POSTS CREATED BY A CONSUMER
	@Override
	public List<Post> readAllForConsumer(String username) {
		Consumer found=consumerService.findByUsername(username);
		if(found==null) return null;
		
		return found.getPosts();
	}
	
	// RETRIEVE ALL THE OPEN POSTS RELATED TO A SERVICE PROVIDER
	@Override
	public List<Post> readAllForServiceProvider(String username) {
//		System.out.println("============= Finding service Provider ===============");
		ServiceProvider found=serviceProviderService.findByUsername(username);
		if(found==null) return null;
		
//		System.out.println("============= Getting City ===============");
		String city=found.getCity();
		
//		System.out.println("============= List of Expertise ===============");
		List<Expertise> elist=found.getExpertise();
		
//		System.out.println("============= Filtering posts now ===============");
		List<Post> plist=postDao.findAllForServiceProvider(city, elist);
		
		return plist;
		
		
	}
	
	
	
	
}
