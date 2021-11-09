package io.fabric8.volcano.client.dsl;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.Queue;
import io.fabric8.volcano.scheduling.v1beta1.QueueList;

public interface V1beta1APIGroupDSL extends Client {
  MixedOperation<PodGroup, PodGroupList, Resource<PodGroup>> PodGroups();
  MixedOperation<Queue, QueueList, Resource<Queue>> Queues();
}
