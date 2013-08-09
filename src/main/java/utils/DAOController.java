/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class DAOController
{

	@Inject
	public org.slf4j.Logger logger;

	@Inject
	Provider<EntityManager> entitiyManagerProvider;

	@Transactional
	public <T> void persist(T bean)
	{

		EntityManager entityManager = entitiyManagerProvider.get();
		entityManager.persist(bean);

	}

	@Transactional
	public <T> void merge(T bean)
	{

		EntityManager entityManager = entitiyManagerProvider.get();
		entityManager.merge(bean);

	}

	@Transactional
	public <T> void remove(T bean)
	{

		EntityManager entityManager = entitiyManagerProvider.get();
		entityManager.remove(entityManager.contains(bean) ? bean : entityManager.merge(bean));

	}

	@Transactional
	public <T> List<T> getAllElements(Class<T> clazz)
	{

		EntityManager entityManager = entitiyManagerProvider.get();
		Query q = entityManager.createQuery("SELECT x FROM " + clazz.getSimpleName());
		return (List<T>) q.getResultList();

	}

	@Transactional
	public <T> T getSingleElement(Class<T> clazz, Long id)
	{

		EntityManager entityManager = entitiyManagerProvider.get();

		Query q = entityManager.createQuery("Select x FROM " + clazz.getSimpleName() + " x WHERE ID=" + id);
		return (T) q.getResultList().get(0);

	}

}
