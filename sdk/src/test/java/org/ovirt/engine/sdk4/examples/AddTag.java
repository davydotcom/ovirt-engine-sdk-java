/*
Copyright (c) 2016 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.ovirt.engine.sdk4.examples;

import static org.ovirt.engine.sdk4.ConnectionBuilder.connection;
import static org.ovirt.engine.sdk4.builders.Builders.tag;

import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.TagsService;

// This example will connect to the server and create a new tag
public class AddTag {
    public static void main(String[] args) throws Exception {
        // Create the connection to the server:
        Connection connection = connection()
            .url("https://engine40.example.com/ovirt-engine/api")
            .user("admin@internal")
            .password("redhat123")
            .trustStoreFile("truststore.jks")
            .build();

        // Get the reference to the tags service:
        TagsService tagsService = connection.systemService().tagsService();

        // Use the "add" method to create new tag:
        tagsService.add()
            .tag(
                tag()
                .name("mytag")
            )
            .send();

        // Close the connection to the server:
        connection.close();
    }
}