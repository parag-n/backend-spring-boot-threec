package com.threec.service;

import java.util.List;

import com.threec.beans.Post;

public interface PostService {

	Post create(Post post, String username);

	List<Post> readAllForConsumer(String username);

}
