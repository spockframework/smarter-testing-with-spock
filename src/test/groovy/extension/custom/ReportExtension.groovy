package extension.custom

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.SpecInfo
import org.spockframework.runtime.model.FeatureInfo

class ReportExtension extends AbstractAnnotationDrivenExtension<Report> {
    @Override
    void visitSpecAnnotation(Report annotation, SpecInfo spec) {
        spec.addListener(new AbstractRunListener() {
            @Override
            void afterFeature(FeatureInfo feature) {
                for (block in feature.blocks) {
                    for (text in block.texts) {
                        println text
                    }
                }
            }
        })
    }
}
