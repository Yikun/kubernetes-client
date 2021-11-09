/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.volcano.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import okhttp3.OkHttpClient;

public class DefaultVolcanoClient extends BaseClient implements NamespacedVolcanoClient {

  public DefaultVolcanoClient() {
    super();
  }

  public DefaultVolcanoClient(Config configuration) {
    super(configuration);
  }

  public DefaultVolcanoClient(OkHttpClient httpClient, Config configuration) {
    super(httpClient, configuration);
  }

  @Override
  public NamespacedVolcanoClient inAnyNamespace() {
    return null;
  }

  @Override
  public NamespacedVolcanoClient inNamespace(String name) {
    return null;
  }

  @Override
  public FunctionCallable<NamespacedVolcanoClient> withRequestConfig(RequestConfig requestConfig) {
    return null;
  }

  @Override
  public MixedOperation<PodGroup, PodGroupList, Resource<PodGroup>> PodGroups() {
    return Handlers.getOperation(PodGroup.class, PodGroupList.class, this.getHttpClient(), this.getConfiguration());
  }
}
