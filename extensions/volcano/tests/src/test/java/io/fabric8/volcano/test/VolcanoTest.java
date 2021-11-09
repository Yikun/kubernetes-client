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
package io.fabric8.volcano.test;
import io.fabric8.volcano.client.VolcanoClient;
import io.fabric8.volcano.scheduling.v1beta1.PodGroup;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupBuilder;
import io.fabric8.volcano.scheduling.v1beta1.PodGroupList;
import io.fabric8.volcano.server.mock.EnableVolcanoMockClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableVolcanoMockClient(crud = true)
class VolcanoTest {
    VolcanoClient client;

  @Test
  void testPodGroup() {
    PodGroup podGroup = new PodGroupBuilder()
      .withNewMetadata()
        .withName("Pod")
        .endMetadata()
      .build();
    client.PodGroups().inNamespace("ns1").create(podGroup);

    PodGroupList podGroupList = client.PodGroups().inNamespace("ns1").list();
    assertNotNull(podGroupList);
    assertEquals(1, podGroupList.getItems().size());
  }

  @Test
  void testV1Beta1PodGroup() {
    PodGroup podGroup = new PodGroupBuilder()
      .withNewMetadata()
      .withName("Pod")
      .endMetadata()
      .build();
    client.PodGroups().inNamespace("ns1").create(podGroup);

    PodGroupList podGroupList = client.v1beta1().PodGroups().inNamespace("ns1").list();
    assertNotNull(podGroupList);
    assertEquals(1, podGroupList.getItems().size());
  }
}
