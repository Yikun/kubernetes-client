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

package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServicePort;
import io.fabric8.kubernetes.api.model.extensions.*;
import io.fabric8.kubernetes.client.utils.internal.URLFromServiceUtil;

public class URLFromIngressImpl implements ServiceToURLProvider {

  @Override
  public String getURL(Service service, String portName, String namespace, KubernetesClient client) {
    ServicePort port = URLFromServiceUtil.getServicePortByName(service, portName);
    String serviceName = service.getMetadata().getName();
    if(port == null) {
      throw new RuntimeException("Couldn't find port: " + portName + " for service " + service.getMetadata().getName());
    }

    IngressList ingresses = client.extensions().ingresses().inNamespace(namespace).list();
    if(ingresses != null && !ingresses.getItems().isEmpty()) {
      return URLFromServiceUtil.getURLFromIngressList(ingresses.getItems(), namespace, serviceName, port);
    }
    return null;
  }

  @Override
  public int getPriority() {
    return ServiceToUrlImplPriority.FIRST.getValue();
  }

}
