/*
 * The MIT License
 *
 * Copyright (c) 2016 CloudBees, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.cloudbees.jenkins.plugins.processor;

import com.cloudbees.jenkins.plugins.BitbucketEvent;
import com.cloudbees.jenkins.plugins.BitbucketJobProbe;
import com.cloudbees.jenkins.plugins.payload.BitbucketPayload;
import com.cloudbees.jenkins.plugins.payload.OldPostBitbucketPayload;
import net.sf.json.JSONObject;

/**
 * Old post payload processor
 * @since August 1, 2016
 * @version 2.0
 */
public class OldPostPayloadProcessor extends BitbucketPayloadProcessor {
    public OldPostPayloadProcessor(BitbucketJobProbe jobProbe, BitbucketEvent bitbucketEvent) {
        super(jobProbe, bitbucketEvent);
    }

    @Override
    public void processPayload(JSONObject payload) {
        BitbucketPayload bitbucketPayload = new OldPostBitbucketPayload(payload);

        jobProbe.triggetMatchingJobs(bitbucketEvent, bitbucketPayload);
    }

}
