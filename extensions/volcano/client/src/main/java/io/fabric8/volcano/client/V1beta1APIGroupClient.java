package io.fabric8.volcano.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.volcano.client.dsl.V1beta1APIGroupDSL;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;
import okhttp3.OkHttpClient;

public class V1beta1APIGroupClient  extends BaseClient implements V1beta1APIGroupDSL {

  public V1beta1APIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<PodGroup, PodGroupList, Resource<PodGroup>> PodGroups() {
    return Handlers.getOperation(PodGroup.class, PodGroupList.class, this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Queue, QueueList, Resource<Queue>> Queues() {
    return Handlers.getOperation(Queue.class, QueueList.class, this.getHttpClient(), this.getConfiguration());
  }
}
