/*
 * Copyright (C) 2015 Kalin Maldzhanski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apptik.json.jsonld.api;


import io.apptik.json.JsonObject;
import io.apptik.json.JsonString;
import io.apptik.json.jsonld.JsonLdWrap;

import java.net.URI;
import java.util.Map;

public class JsonLdContext {

    private JsonLdOptions options;
    //context json object containing json-ld known terms
    private JsonLdWrap ctx;
    //only term definitions
    private JsonObject termDefinitions;
    public JsonObject inverse = null;


    public JsonLdContext() {
        this(new JsonLdOptions());
    }

    public JsonLdContext(JsonLdOptions opts) {
        init(opts);
    }

    public JsonLdContext(Map<String, Object> map, JsonLdOptions opts) {
        ctx = new JsonLdWrap(new JsonObject(map));
        init(opts);
    }

    public JsonLdContext(Map<String, Object> map) {
        this(map, new JsonLdOptions());
    }

    public JsonLdContext(URI context, JsonLdOptions opts) {
        throw new RuntimeException("TODO");
        //init(opts);
    }

    private void init(JsonLdOptions options) {
        if(ctx==null) {
            ctx =  new JsonLdWrap();
        }
        this.options = options;
        if (options.getBase() != null) {
            ctx.setBase(new JsonString(options.getBase()));
        }
       
    }

    @Override
    public String toString() {
        return ctx.getJson().merge(termDefinitions).toString();
    }
}
