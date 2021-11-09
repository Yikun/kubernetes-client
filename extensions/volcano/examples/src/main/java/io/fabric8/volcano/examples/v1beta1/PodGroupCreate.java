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
package io.fabric8.volcano.examples.v1beta1;

import io.fabric8.volcano.client.DefaultVolcanoClient;
import io.fabric8.volcano.client.NamespacedVolcanoClient;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupBuilder;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupSpecBuilder;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupSpec;

public class PodGroupCreate {
  public static void main(String[] args) {
    try (NamespacedVolcanoClient volcanoClient = new DefaultVolcanoClient()) {
      String namespace = "default";

      PodGroup podGroup = new PodGroupBuilder().build();

      PodGroupSpec podGroupSpec = new PodGroupSpecBuilder().build();

      // Create PodGroup
      volcanoClient.PodGroups().inNamespace(namespace).create(podGroup);
      System.out.println("Created: " + podGroup.getMetadata().getName());

      // List PodGroup
      PodGroupList podGroupList = volcanoClient.PodGroups().inNamespace(namespace).list();
      System.out.println("There are " + podGroupList.getItems().size() + " PodGroup objects in " + namespace);
    }
  }
}
